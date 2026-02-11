package com.bankapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;
import com.bankapp.repo.projections.AccountSummary;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    // 1️ Exists check
    boolean existsById(int id);

    // 2️ BAD (causes N+1 if transactions accessed)
    @Query("select a from Account a")
    List<Account> findAllAccounts();

    // 3️ FETCH JOIN (fixes N+1)
    @Query("""
        select distinct a
        from Account a
        left join fetch a.transactions
        where a.id = :id
    """)
    Optional<Account> findAccountWithTransactions(@Param("id") int id);

    // 4️ Projection for API / listing
    @Query("""
        select a.id as id,
               a.name as name,
               a.balance as balance
        from Account a
    """)
    List<AccountSummary> findAccountSummaries();

    // 5️ Projection by id
    @Query("""
        select a.id as id,
               a.name as name,
               a.balance as balance
        from Account a
        where a.id = :id
    """)
    Optional<AccountSummary> findAccountSummaryById(
            @Param("id") int id
    );
}
