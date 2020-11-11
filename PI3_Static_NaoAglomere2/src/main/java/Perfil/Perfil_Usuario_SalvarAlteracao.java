/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perfil;

import Cad_Empresa.Cad_EmpresaDados;
import Cad_Empresa.EmpresaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "Perfil_Usuario_SalvarAlteracao", urlPatterns = {"/perfil-alterado"})
public class Perfil_Usuario_SalvarAlteracao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        String sucesso = (String) sessao.getAttribute("sucesso");
        Cad_EmpresaDados empresa_dados = (Cad_EmpresaDados) sessao.getAttribute("empresa");
        sessao.removeAttribute("empresa");

        request.setAttribute("empresa", empresa_dados);
        request.setAttribute("sucesso", sucesso);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Perfil/Perfil_entrada.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //ALTERAÇÃO DE DADOS DA EMPRESA ------COMEÇO------
        request.setCharacterEncoding("UTF-8");

        String nome_empresa = request.getParameter("nome_empresa");
        String CNPJ = request.getParameter("CNPJ");
        String email = request.getParameter("email");
        //String senha = request.getParameter("senha");
        //String confirmasenha = request.getParameter("confirmasenha");
        String telefone = request.getParameter("telefone");
        String descricao = request.getParameter("descricao");
        String rua = request.getParameter("rua");
        String numeroStr = request.getParameter("numero_rua");
        String bairro = request.getParameter("bairro");
        String qtd_pessoasStr = request.getParameter("qtd_pessoas");
        String regras = request.getParameter("regras");
        String agendamento = request.getParameter("agendamento");
        
        System.out.println(nome_empresa);
        System.out.println(CNPJ);
        System.out.println(email);
        System.out.println(telefone);
        System.out.println(descricao);
        System.out.println(rua);
        System.out.println(numeroStr);
        System.out.println(bairro);
        System.out.println(qtd_pessoasStr);
        System.out.println(regras);
        System.out.println(agendamento);

        //Validação Nome
        boolean nomeValido = nome_empresa != null && nome_empresa.trim().length() > 0;

        //Validação email
        boolean emailValido = (email != null && email.trim().length() > 0);
        if (emailValido) {
            Pattern emailPattern = Pattern.compile("^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$");
            Matcher emailMatcher = emailPattern.matcher(email);
            emailValido = emailValido && emailMatcher.matches();
        }
        

        //validação senha
        //boolean senhaValida = (senha != null && senha.trim().length() >= 8);

        //Senhas Iguais
        //boolean ConfirmaSenhaValida = (confirmasenha != null && confirmasenha.equals(senha));

        //Validação CNPJ
        boolean validaCNPJ = CNPJ != null && CNPJ.trim().length() > 0;
        //boolean validaCNPJ = isCNPJ(CNPJ); VALIDAR CNPJ REAL

        //Validação telefone 
        boolean telefoneValido = telefone != null && telefone.trim().length() > 0;
        if (telefoneValido) {
            Pattern telefonePattern = Pattern.compile("(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})");
            Matcher telefoneMatcher = telefonePattern.matcher(telefone);
            telefoneValido = telefoneValido && telefoneMatcher.matches();
        }

        //Validação descricao
        boolean descricaoValida = descricao != null && descricao.trim().length() > 0;

        //Validação rua
        boolean ruaValida = rua != null && rua.trim().length() > 0;

        //Validação número
        Integer numero = null;
        boolean numeroValido = numeroStr != null && numeroStr.trim().length() > 0;
        if (numeroValido) {
            numero = Integer.parseInt(numeroStr);
        }

        //Validação bairro
        boolean bairroValido = bairro != null && bairro.trim().length() > 0;

        //Validação quantidade de pessoas
        Integer qtdPessoas = null;
        boolean qtdValida = qtd_pessoasStr != null && qtd_pessoasStr.trim().length() > 0;
        if (qtdValida) {
            qtdPessoas = Integer.parseInt(qtd_pessoasStr);
        }

        //Validação regras
        boolean regrasValidas = regras != null && regras.trim().length() > 0;
        
        //Validação Nome
        boolean agendamentoValido = agendamento != null && agendamento.trim().length() > 0;

        boolean camposValidos = nomeValido && emailValido && validaCNPJ && telefoneValido && ruaValida
                && numeroValido && bairroValido && descricaoValida && qtdValida && regrasValidas /*&& senhaValida
                && ConfirmaSenhaValida*/ && agendamentoValido;

        if (!camposValidos) {

            if (!nomeValido) {
                request.setAttribute("nomeErro", "Nome inválido ou deve ser preenchido");
            }
            if (!emailValido) {
                request.setAttribute("emailErro", "Email inválido ou deve ser preenchido");
            }
            if (!validaCNPJ) {
                request.setAttribute("cnpjErro", "CPNJ inválido ou deve ser preenchido");
            }
            /*if (!senhaValida) {
                request.setAttribute("senhaErro", "Senha inválida ou deve ser preenchida");
            }
            if (!ConfirmaSenhaValida) {
                request.setAttribute("confirmaErro", "Senhas devem ser iguais");
            }*/
            if (!telefoneValido) {
                request.setAttribute("telefoneErro", "Telefone inválido ou deve ser preenchido");
            }
            if (!ruaValida) {
                request.setAttribute("ruaErro", "Rua inválida ou deve ser preenchida");
            }
            if (!numeroValido) {
                request.setAttribute("numeroErro", "Número inválido ou deve ser preenchido");
            }
            if (!bairroValido) {
                request.setAttribute("bairroErro", "Bairro inválido ou deve ser preenchido");
            }
            if (!descricaoValida) {
                request.setAttribute("descricaoErro", "Descrição deve ser selecionada");
            }
            if (!qtdValida) {
                request.setAttribute("qtdErro", "Quantidade inválida ou deve ser preenchida");
            }
            if (!regrasValidas) {
                request.setAttribute("regrasErro", "Regras inválidas ou devem ser preenchidas");
            }
            if(!agendamentoValido){
                request.setAttribute("agendamentoErro", "Uma opção deve ser selecionada");
            }

            request.setAttribute("nome_empresa", nome_empresa);
            request.setAttribute("CNPJ", CNPJ);
            request.setAttribute("email", email);
            request.setAttribute("telefone", telefone);
            request.setAttribute("descricao", descricao);
            request.setAttribute("rua", rua);
            request.setAttribute("numero_rua", numeroStr);
            request.setAttribute("bairro", bairro);
            request.setAttribute("qtd_pessoas", qtd_pessoasStr);
            request.setAttribute("regras", regras);
            request.setAttribute("agendamento", agendamento);
            request.setAttribute("Erro", "Erro no banco de dados2");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Perfil/Perfil_entrada.jsp");
            dispatcher.forward(request, response);
            return;

        }

        Cad_EmpresaDados empresa_dados = new Cad_EmpresaDados();

        empresa_dados.setNome_Empresa(nome_empresa);
        empresa_dados.setCNPJ(CNPJ);
        empresa_dados.setEmail(email);
        //empresa_dados.setSenha(senha);
        empresa_dados.setTelefone(telefone);
        empresa_dados.setDescricao(descricao);
        empresa_dados.setRua(rua);
        empresa_dados.setNumero_Rua(numero);
        empresa_dados.setBairro(bairro);
        empresa_dados.setQtd_max(qtdPessoas);
        empresa_dados.setRegras(regras);
        empresa_dados.setAgendamento(agendamento);

        EmpresaDao dao = new EmpresaDao();

        try {
            
            dao.update(empresa_dados);

            request.setAttribute("empresa", empresa_dados);
            request.setAttribute("sucesso", "Alterado com sucesso!");
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("empresa", empresa_dados);
            sessao.setAttribute("sucesso", "Alterado com sucesso!");
            response.sendRedirect("perfil-alterado");

        } catch (SQLException e) {

            request.setAttribute("Erro", "Erro no banco de dados");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Perfil/Perfil_entrada.jsp");
            dispatcher.forward(request, response);
        }
        //ALTERAÇÃO DE DADOS DA EMPRESA ------FIM-------
        
    }

}
