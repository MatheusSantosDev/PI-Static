/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agendamento;

import Cad_Usuario.Cad_Usuario;
import ConexãoBD.Connection_db2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import Cad_Empresa.*;

/**
 *
 * @author Gabriel
 */
public class AgendamentoDAO {

    public void addAgendamento(Agendamento agend) throws SQLException {
        String sql = "insert into agendamento (email,usuario_id,telefone,empresa_id,data_Agend,horario) values (?,?,?,?,?,?);";
        try (Connection conn = Connection_db2.obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, agend.getEmail());
                stmt.setInt(2, agend.getIdUsuario());
                stmt.setString(3, agend.getTelefone());
                stmt.setInt(4, agend.getIdEmpresa());
                stmt.setString(5, String.valueOf(agend.getData()));
                stmt.setString(6, agend.getHora());

                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }

    }

    public int findByEmail(String emailUser) throws SQLException {
        Agendamento a = new Agendamento();
        String sql = "select id from usuario where email = ?";

        try (Connection conn = Connection_db2.obterConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, emailUser);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    a.setIdUsuario(rs.getInt("id"));

                }

            }
        }
        return a.getIdUsuario();
    }

    public int findyByNameEmp(String nomeEmp) throws SQLException {
        Agendamento emp = new Agendamento();
        int result = 0;

        String sql = "select ID_empresa from empresa where Nome_Empresa = ?";

        try (Connection conn = Connection_db2.obterConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, nomeEmp);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    emp.setIdEmpresa(rs.getInt("ID_empresa"));
                    result = emp.getIdEmpresa();
                } else {
                    result = -1;
                }

            }
        }
        return result;

    }

}
