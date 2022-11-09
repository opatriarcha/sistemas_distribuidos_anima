/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uam.sd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author orlando
 */
public class PessoaRepository {
    private final static HashMap<Integer, Pessoa> pessoas = new HashMap<>();

    public List<Pessoa> GetAll(){
        return new ArrayList<Pessoa>(pessoas.values());
    }

    public Pessoa Get(final int id) {
        return pessoas.get(id);
    }

    public void Add(final Pessoa pessoa) {
        if(pessoa.getId() == 0 )
            pessoa.setId(generateId(pessoas.size() + 1));
        pessoas.put(pessoa.getId(), pessoa);
    }

    public void Edit(final Pessoa pessoa) {
        pessoas.remove(pessoa.getId());
        pessoas.put(pessoa.getId(), pessoa);
    }

    public void Delete(final int id) {
        pessoas.remove(id);
    }

    private int generateId(final int possible)
    {
        if(pessoas.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }
}

