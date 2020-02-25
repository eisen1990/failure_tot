package com.example.chipmngt.dao;

import java.util.List;

import com.example.chipmngt.dto.ShipmentDTO;

public interface ShipmentDAO {
	public void insertShipment(List<ShipmentDTO> sDTO);
}
