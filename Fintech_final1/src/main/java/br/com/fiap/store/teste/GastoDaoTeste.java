package br.com.fiap.store.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.T_GASTO;
import br.com.fiap.fintech.dao.T_GastoDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class GastoDaoTeste {

    public static void main(String[] args) {

        T_GastoDao dao = DAOFactory.getGastoDao();

        T_GASTO gasto = new T_GASTO(0, 1, 25, "Camiseta", 150, Calendar.getInstance());

//        try {
//            dao.cadastrar(gasto);
//            System.out.println("Gasto cadastrado!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

         //Buscar Gasto
//         gasto = dao.buscar(6);
//         gasto.setDes_gasto("Bone");
//         gasto.setVal_gasto(450);
//         try {
//         dao.atualizar(gasto);
//         System.out.println("Gasto Atualizado");
//         } catch (DBException e) {
//         e.printStackTrace();
//         }

        // Listar Gastos
        List<T_GASTO> lista = dao.listar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (T_GASTO item : lista) {
            System.out.println(
                    item.getCod_gasto() + " " + item.getCod_usuario() + " " + item.getCod_categoria() + " "
                            + item.getDes_gasto() + " " + item.getVal_gasto() + " " + dateFormat.format(item.getDat_gasto().getTime()));
        }

        // Remover Gasto
         try {
         dao.remover(7);
         System.out.println("Gasto Removido");
         } catch (DBException e) {
         e.printStackTrace();
         }
    }
}
