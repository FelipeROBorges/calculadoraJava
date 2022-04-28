package calculadora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Pedro
 */
public class calcularValor {

    public double calcularValor(Date dataDeVencimento, Date dataAtual, double valorDaDivida) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
        int dia1, mes1, ano1, dia2, mes2, ano2, diaV = 0, mesV = 0, anoV = 0;
        double valorTotal = 0;
        Calendar calendario = Calendar.getInstance();

        calendario.setTime(dataDeVencimento);
        ano1 = calendario.get(Calendar.YEAR);
        mes1 = calendario.get(Calendar.MONTH);
        dia1 = calendario.get(Calendar.DAY_OF_MONTH);

        calendario.setTime(dataAtual);
        ano2 = calendario.get(Calendar.YEAR);
        mes2 = calendario.get(Calendar.MONTH);
        dia2 = calendario.get(Calendar.DAY_OF_MONTH);

        Date date1 = sdf.parse(dia1 + "-" + mes1 + "-" + ano1); // data de vencimento
        Date date2 = sdf.parse(dia2 + "-" + mes2 + "-" + ano2);// data do pagamento (até qual dia o juros deve contar)

//        System.out.println("[debug]date1 : " + sdf.format(date1));
//        System.out.println("[debug]date2 : " + sdf.format(date2));
//        System.out.println("[debug]datacompara: " + date1.compareTo(date2));

        if (date2.compareTo(date1) > 0) {
//            System.out.println("[debug]date2 é depois de date1");
            valorTotal = valorDaDivida * 0.2;
            if (ano1 < ano2) {
                anoV = ano2 - ano1;

            }
            if (mes1 < mes2) {
                mesV = mes2 - mes1;
            }

            if (dia1 < dia2) {
                diaV = dia2 - dia1;
            }
        }
//        System.out.println("[debug]anoV" + anoV);
        int ApD = anoV * 360;
//        System.out.println("[debug]ApD" + ApD);
        int MpD = mesV * 28;
//        System.out.println("[debug]MpD" + MpD);
        int diaTotal = ApD + MpD + diaV;
//        System.out.println("[debug]diatotal: " + diaTotal);
        double totalFinal = valorTotal * 0.35 * diaTotal;

//        System.out.println("[debug]totalFinal:" + totalFinal);
        return totalFinal;
    }
}
