package com.weighbridge.weighbridgeoperator.repositories;

import com.weighbridge.weighbridgeoperator.entities.WeighmentTransaction;
import com.weighbridge.weighbridgeoperator.payloads.WeighmentTransactionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeighmentTransactionRepository extends JpaRepository<WeighmentTransaction,Integer> {


   WeighmentTransaction findByGateEntryTransactionTicketNo(Integer ticketNo);

   @Query("SELECT g.ticketNo, w.weighmentNo, g.transactionType, g.transactionDate, g.vehicleIn, " +
           "w.grossWeight, w.tareWeight, w.netWeight, w.temporaryWeight, " +
           "v.vehicleNo, v.vehicleFitnessUpTo, " +
           "s.supplierName, t.transporterName, " +
           "m.materialName " +
           "FROM GateEntryTransaction g " +
           "LEFT JOIN WeighmentTransaction w ON g.ticketNo = w.gateEntryTransaction.ticketNo  " +
           "INNER JOIN VehicleMaster v ON v.id = g.vehicleId " +
           "INNER JOIN SupplierMaster s ON s.supplierId = g.supplierId " +
           "INNER JOIN TransporterMaster t ON t.id = g.transporterId " +
           "INNER JOIN MaterialMaster m ON m.materialId = g.materialId " +
           "INNER JOIN VehicleTransactionStatus ts ON ts.ticketNo = g.ticketNo " +
           "WHERE g.siteId = :siteId and w.netWeight IS NULL " +
           "ORDER BY g.transactionDate DESC")
   List<Object[]> getAllGateEntries(@Param("siteId") String siteId);

}