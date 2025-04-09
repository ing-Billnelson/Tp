package Vole;
import Vole.Object;
import java.sql.*;

public class Connexion_to_db {
    private final String URL = "jdbc:mysql://localhost:3306/volObj";
    private final String USER = "demanou";
    private final String PASSWORD = "motdepasse";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void enregistrerObjet(Object objet) {
        String sql = "INSERT INTO objets (type, numero_serie, marque, vole) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, objet.getType());
            stmt.setString(2, objet.getNumeroSerie());
            stmt.setString(3, objet.getMarque());
            stmt.setBoolean(4, objet.isVole());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean estVole(String numeroSerie) {
        String sql = "SELECT vole FROM objets WHERE numero_serie = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeroSerie);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("vole");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
