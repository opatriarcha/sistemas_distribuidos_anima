package org.sd.revisao.oo;

/**
 *
 * @author orlando
 */
public class Fatura {
    private String id;
    private String descricao;
    private Integer quantidadeComprada;
    private Double preco;
    
   public Fatura( String id, String descricao, Integer quantidadeComprada, Double preco){
       this.id = id;
       this.descricao = descricao;
       this.quantidadeComprada = quantidadeComprada;
       this.preco = preco;
   } 
   
   public Double getTotalFatura(){
       Double totalFatura = quantidadeComprada * preco;
       if( totalFatura < 0 )
           return 0.0;
       else
           return totalFatura;
   }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the quantidadeComprada
     */
    public Integer getQuantidadeComprada() {
        return quantidadeComprada;
    }

    /**
     * @param quantidadeComprada the quantidadeComprada to set
     */
    public void setQuantidadeComprada(Integer quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Fatura{" + "id=" + id + ", descricao=" + descricao + ", quantidadeComprada=" + quantidadeComprada + ", preco=" + preco + '}';
    }
}

