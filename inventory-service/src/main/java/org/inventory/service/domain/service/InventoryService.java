package org.inventory.service.domain.service;

import org.inventory.service.domain.model.Inventory;
import org.inventory.service.infrastructure.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Obtener todo el inventario
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // Crear un nuevo registro de inventario
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Actualizar un registro de inventario existente
    public Inventory updateInventory(Long id, Inventory inventoryDetails) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        inventory.setProductName(inventoryDetails.getProductName());
        inventory.setQuantity(inventoryDetails.getQuantity());

        return inventoryRepository.save(inventory);
    }

    // Eliminar un registro de inventario
    public void deleteInventory(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        inventoryRepository.delete(inventory);
    }
}
