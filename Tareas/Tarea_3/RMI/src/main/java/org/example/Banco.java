package org.example;

import org.example.interfaces.IBanco;
import org.example.interfaces.IEmpresa;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Banco extends UnicastRemoteObject implements IBanco {
    public Banco() throws RemoteException {
        super();
    }
    @Override
    public Factura[] calcular(int idCliente) throws RemoteException, MalformedURLException, NotBoundException {
        IEmpresa cessa = (IEmpresa) Naming.lookup("rmi://localhost/Cessa");
        Factura[] facturaCessa = cessa.pendiente(idCliente);

        IEmpresa cotes = (IEmpresa) Naming.lookup("rmi://localhost/Cotes");
        Factura[] facturasCotes = cotes.pendiente(idCliente);

        return getTotalFacturas(facturaCessa, facturasCotes);
    }

    private Factura[] getTotalFacturas(Factura[] facturasCessa, Factura[] facturasCotes){
        Factura[] totalFacturas = new Factura[facturasCessa.length + facturasCotes.length];
        int i = 0;
        for (Factura factura: facturasCessa){
            totalFacturas[i] = factura;
            i++;
        }

        for(Factura factura: facturasCotes){
            if (factura == null){
                break;
            }
            totalFacturas[i] = factura;
            i++;
        }

        return totalFacturas;
    }

    @Override
    public String pagar(Factura[] facturas) throws RemoteException, MalformedURLException, NotBoundException {
        IEmpresa cessa = (IEmpresa) Naming.lookup("rmi://localhost/Cessa");

        IEmpresa cotes = (IEmpresa) Naming.lookup("rmi://localhost/Cotes");
        int cessaFacturasCount = 0;
        int cotesFacturasCount = 0;


        for(Factura factura : facturas){

            if( factura!= null && factura.getEmpresa().getNombre().equals("Cessa")){
                cessaFacturasCount++;
            }
            if (factura!= null && factura.getEmpresa().getNombre().equals("Cotes")){
                cotesFacturasCount++;
            }
        }

        String cessaPagoResponse = cessa.pagar(getFacturasCessa(facturas, cessaFacturasCount));

        String cotesPagoResponse = cotes.pagar(getFacturasCotes(facturas, cotesFacturasCount));

        return cessaPagoResponse + "\n" + cotesPagoResponse;
    }

    private Factura[] getFacturasCotes(Factura[] facturas, int cotesFacturasCount){
        if(cotesFacturasCount == 0){
            return null;
        }


        int i = 0;
        Factura[] facturasCotes = new Factura[cotesFacturasCount];
        for(Factura factura : facturas){
            if(factura != null && factura.getEmpresa().getNombre().equals("Cotes")){
                facturasCotes[i] = factura;
                i++;
            }
        }
        return facturasCotes;
    }

    private Factura[] getFacturasCessa(Factura[] facturas, int cessaFacturasCount){
        if(cessaFacturasCount == 0){
            return null;
        }

        int i = 0;
        Factura[] facturasCessa = new Factura[cessaFacturasCount];
        for(Factura factura : facturas){

            if(factura != null && factura.getEmpresa().getNombre().equals("Cessa")){
                facturasCessa[i] = factura;
                i++;
            }
        }
        return facturasCessa;
    }
}
