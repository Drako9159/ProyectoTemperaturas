import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Scanner;
public class ProyectoTemperaturas {
    private Scanner item = new Scanner(System.in);
    private double[][] temps = new double [7][2]; //Aquí se guardan las temperaturas máximas y mínimas
    private String[] semana= {"LUNES","MARTES","MIÉRCOLES","JUEVES","VIERNES","SÁBADO","DOMINGO"};
    public void IngresaTemperaturas() {
        for (int i = 0; i < temps.length; i++) {
            System.out.println("Ingresa la temperatura máxima del dia " + semana[i]);
            temps[i][0] = item.nextDouble(); //Máximas en la columna 0
            System.out.println("Ingresa la temperatura mínima del dia " + semana[i]);
            temps[i][1] = item.nextDouble(); //Minimas en la columna 1
        }
    }
    public static int  findIndex (double[] my_array, double t) {//Este método va a revelar la posición de la temperatura más alta
        if (my_array == null) return -1;
        int len = my_array.length;
        int i = 0;
        while (i < len) {
            if (my_array[i] == t) return i;
            else i = i + 1;
        }
        return -1;
    }
    public void MayorTemperatura(){
        double[] a = new double[7];
        for(int i=0; i< temps.length; i++){
            a[i] = temps[i][0];//Se crea otro array con las temperaturas mayores
        }
        double max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i] > max){
                max = a[i];//Se evalúa el mayor valor en el array
            }
        }
        int position = findIndex(a, max) + 1; //Aquí se manda el array de temperaturas máximas y el valor a encontrar
        System.out.println(position);
        switch (position){//El switch manda el mensaje tomando en cuenta la posición de la temperatura para encontrar el día de la semana
            case 1:{
                System.out.println("La temperatura más alta de "+max+"°C se presentó el día "+semana[0]);
                break;
            }
            case 2:{
                System.out.println("La temperatura más alta de "+max+" se presentó el día "+semana[1]);
                break;
            }
            case 3:{
                System.out.println("La temperatura más alta de "+max+" se presentó el día "+semana[2]);
                break;
            }
            case 4:{
                System.out.println("La temperatura más alta de "+max+" se presentó el día "+semana[3]);
                break;
            }
            case 5:{
                System.out.println("La temperatura más alta de "+max+" se presentó el día "+semana[4]);
                break;
            }
            case 6:{
                System.out.println("La temperatura más alta de "+max+" se presentó el día "+semana[6]);
                break;
            }
            case 7:{
                System.out.println("La temperatura más alta de "+max+" se presentó el día "+semana[7]);
                break;
            }
        }
    }
    public void Listar(){//Con esto se listan las temperaturas de cada día
        System.out.println("Estos son las temperaturas de cada día: ");
        for(int i=0; i<temps.length; i++){
            System.out.println("\nDía "+semana[i]+" temp max: "+temps[i][0]+"°C - temp min: "+temps[i][1]+"°C");
        }
    }
    public void ConsultDay(int day){//Aquí se hacen las consultas por día seleccionado
        day = day - 1;
        System.out.println("La temperatura del dia :"+semana[day]+" max: "+temps[day][0]+"°C - min: "+temps[day][1]+"°C");
        System.out.println("¿Quiere consultar otro día? (s/n)");
        String consult;
        consult = item.next();
        if("s".equals(consult)){
            System.out.println("Seleccione el día de la semana (1 ,2 ,3 ,4 ,5 ,6 ,7 )");
            int dayAnother = item.nextInt();
            ConsultDay(dayAnother);
        } else {
            Listar();
        }
    }
    public void Consulta(){//Aquí se evalua si se quiere o no consultar las temperaturas de un día
        System.out.println("¿Quiere consultar la temperatura de un día en concreto? (s/n)");
        String consult;
        consult = item.next();
        if("s".equals(consult)){
            System.out.println("Seleccione el día de la semana (1 ,2 ,3 ,4 ,5 ,6 ,7 )");
            int day = item.nextInt();
            ConsultDay(day);
        } else {
            Listar();
        }
    }
    public static void main(String[] args) {//El método que ejecuta todo el proceso, se recomienda organizar todo por separado, en otra clase
        ProyectoTemperaturas run = new ProyectoTemperaturas();
        run.IngresaTemperaturas();
        run.MayorTemperatura();
        run.Consulta();

    }
}
