package sv.edu.ufg.rrhh.utils;

public class SalarioUtils {

    public static double calcularSalarioLiquido(double salario) {
        double isss = calcularISSS(salario);
        double afp = calcularAFP(salario);
        double renta = calcularRenta(salario, afp, isss);

        return salario - (isss + afp + renta);
    }

    public static double calcularISSS(double salario) {
        double resultado = salario * 0.03D;
        return Math.min(resultado, 30.0D);
    }

    public static double calcularAFP(double salario) {
        return salario * 0.0725D;
    }

    public static double calcularRenta(double salario, double afp, double isss) {
        double salarioGravado = salario - (isss + afp);

        if (salarioGravado < 472.00) { // TRAMO I
            return 0.00;
        } else if (salarioGravado > 472.01 && salarioGravado < 895.24) { // TRAMO II
            return ((salarioGravado - 472.00) * 0.10) + 17.67;
        } else if (salarioGravado > 895.25 && salarioGravado < 2038.10) { // TRAMO III
            return ((salarioGravado - 895.24) * 0.20) + 60.00;
        } else { // TRAMO IV
            return ((salarioGravado - 2038.10) * 0.30) + 288.57;
        }
    }
}
