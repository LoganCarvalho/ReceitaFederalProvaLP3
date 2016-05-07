

package Model.Bean;

import Mode.DAO.cadastroReceitaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class declaracaoImpostoRenda {
    
    private String cpf;
    private String nome;
    private int anoReferencia;
    private float valorTotalReceitas;
    private float valorTotalDespesas;
    private float valorPagoImpostoAno;
    private float imposto;

  
    public declaracaoImpostoRenda() {
    }

    public declaracaoImpostoRenda(String cpf, String nome, int anoReferencia, float valorTotalReceitas, float valorTotalDespesas, float valorPagoImpostoAno) {
        this.cpf = cpf;
        this.nome = nome;
        this.anoReferencia = anoReferencia;
        this.valorTotalReceitas = valorTotalReceitas;
        this.valorTotalDespesas = valorTotalDespesas;
        this.valorPagoImpostoAno = valorPagoImpostoAno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public float getValorTotalReceitas() {
        return valorTotalReceitas;
    }

    public void setValorTotalReceitas(float valorTotalReceitas) {
        this.valorTotalReceitas = valorTotalReceitas;
    }

    public float getValorTotalDespesas() {
        return valorTotalDespesas;
    }

    public void setValorTotalDespesas(float valorTotalDespesas) {
        this.valorTotalDespesas = valorTotalDespesas;
    }

    public float getValorPagoImpostoAno() {
        return valorPagoImpostoAno;
    }

    public void setValorPagoImpostoAno(float valorPagoImpostoAno) {
        this.valorPagoImpostoAno = valorPagoImpostoAno;
    }
    
      public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }
    
    public int calcularImposto(declaracaoImpostoRenda dir) {

         int resposta= 0;
         float min = 2000;
         float max = 4000;
         float rest;
         float taxImp = (float) 0.05;
         float taxImpMax = (float) 0.07;
         float valorT = dir.getValorTotalReceitas();
         if (valorT <= min) {
             try {
                 resposta = 1;
                 incluir(dir);
             } catch (Exception ex) {
                 Logger.getLogger(declaracaoImpostoRenda.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         else if ((valorT > min) && (valorT <= max)) {
            float newValorTotal = 0;
            float valorPagoAno = dir.getValorPagoImpostoAno();
            
            newValorTotal=  valorT * taxImp;
            rest = newValorTotal - valorPagoAno;
            dir.setImposto(rest);
             try {
                 resposta = 1;
                 incluir(dir);
             } catch (Exception ex) {
                 Logger.getLogger(declaracaoImpostoRenda.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         else if (valorT > max) {
            float newValorTotal = 0;
            float valorPagoAno = dir.getValorPagoImpostoAno();
             
            newValorTotal=  valorT * taxImpMax;
            rest = newValorTotal - valorPagoAno;
            dir.setImposto(rest);
             try {
                 resposta = 1;
                 incluir(dir);
             } catch (Exception ex) {
                 Logger.getLogger(declaracaoImpostoRenda.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }      
       
        return resposta;
    }
    
     
     public int incluir(declaracaoImpostoRenda dir) throws Exception {

         int resposta= 0;
         try {
              cadastroReceitaDAO responsavelDao = new cadastroReceitaDAO();
              resposta = responsavelDao.incluir(dir);
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
    
}
