package model.seletor.carros;

import model.seletor.BaseSeletor;

public class CarroSeletor extends BaseSeletor {

    private String modelo;
    private Integer anoInicial;
    private Integer anoFinal;
    private Double valorInicial;
    private Double valorFinal;

    public boolean temFiltro() {
        return (this.modelo != null && !this.modelo.isEmpty())
            || (this.anoInicial != null && this.anoFinal != null)
            || (this.valorInicial != null && this.valorFinal != null);
    }

    public CarroSeletor() {}

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoInicial() {
        return anoInicial;
    }

    public void setAnoInicial(Integer anoInicial) {
        this.anoInicial = anoInicial;
    }

    public Integer getAnoFinal() {
        return anoFinal;
    }

    public void setAnoFinal(Integer anoFinal) {
        this.anoFinal = anoFinal;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
}