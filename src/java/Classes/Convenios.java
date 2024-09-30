
package Classes;

public class Convenios {
    private int id;
    private String nome_empresa;
    private String cnpj;
    private String telefone;

    
    
    
    public Convenios(String nome_empresa, String cnpj, String telefone) {
        this.nome_empresa = nome_empresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }
    
    
    
    public Convenios(){

    }

    
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
    
    

    
    
    
    
   
   
   
   
   
   
    
    
    
}
