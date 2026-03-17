package exercicio03;

import java.util.Random;

public class BilheteUnico {
    int numero;
    double saldo;
    final static double tarifaBase = 5.4;
    Usuario usuario;

    public BilheteUnico(Usuario usuario) {
        this.numero = gerarNumero();
        this.saldo = 0;
        this.usuario = usuario;

    }

    public int gerarNumero() {
        Random random = new Random();
        return random.nextInt(1000, 9999);
    }

    public void carregar(double valor) {
        this.saldo += valor;
    }

    public double calcularTarifa(){
        double valor = tarifaBase;
        if (usuario.tipoTarifa.equalsIgnoreCase("estudante") ||
                usuario.tipoTarifa.equalsIgnoreCase("professor")) {
                valor = tarifaBase / 2;
        }
        return valor;
    }

    public boolean passarNaCatraca() {
        double valor = calcularTarifa();
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

}
