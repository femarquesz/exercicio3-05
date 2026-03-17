package exercicio01;

public class MonitorEnergia {
    double[] consumo;
    int indice;

    public MonitorEnergia(int tamanho) {
        this.consumo = new double[tamanho];
    }

    public void registrar(double valor) {
        if(indice < consumo.length) {
            consumo[indice] = valor;
            indice++;
        }
    }

    public double calcularMedia() {
        return calcularMedia(1, indice);
    }

    public double calcularMedia(int inicio, int fim) {
        double media = 0;
        for(int i = inicio - 1; i < fim; i++) {
            media += consumo[i];
        }
        return media / (fim - inicio + 1);
    }

}
