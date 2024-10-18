package br.com.dio.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import br.com.dio.api.model.User;

@Repository
public class UserRepository {

    // Lista estática que simula a base de dados
    private static List<User> users = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong(); // Para gerar IDs incrementais

    // Bloco estático para adicionar alguns usuários fictícios à lista ao iniciar
    static {
        users.add(new User(idCounter.incrementAndGet(), "user1", "password123"));
        users.add(new User(idCounter.incrementAndGet(), "user2", "password456"));
        users.add(new User(idCounter.incrementAndGet(), "user3", "password789"));
    }

    // CREATE: Adicionar um novo usuário
    public User save(User user) {
        user.setId(idCounter.incrementAndGet()); // Gerar ID automaticamente
        users.add(user);
        return user;
    }

    // READ: Buscar um usuário por ID
    public Optional<User> get(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    // READ: Listar todos os usuários
    public List<User> all() {
        return new ArrayList<>(users);
    }

    // UPDATE: Atualizar informações de um usuário existente
    public Optional<User> update(Long id, User updatedUser) {
        return get(id).map(existingUser -> {
            existingUser.setLogin(updatedUser.getLogin());
            existingUser.setPassword(updatedUser.getPassword());
            return existingUser;
        });
    }

    // DELETE: Remover um usuário por ID
    public boolean delete(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
