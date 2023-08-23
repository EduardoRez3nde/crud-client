package com.rezende.CRUDClient.services;

import com.rezende.CRUDClient.dto.ClientDTO;
import com.rezende.CRUDClient.entities.Client;
import com.rezende.CRUDClient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }
    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDto(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        Client entity = repository.getReferenceById(id);
        copyDto(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void copyDto (ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());

    }

}
