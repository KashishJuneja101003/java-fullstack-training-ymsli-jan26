package com.bankapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.BankTxType;
import com.bankapp.entities.TxHistory;
import com.bankapp.repo.projections.TxView;

@Repository
public interface TxHistoryRepo extends JpaRepository<TxHistory, Long> {

    // 1️ Transaction list (projection)
    @Query("""
        select t.type as type,
               t.amount as amount,
               t.balanceAfterTx as balanceAfterTx,
               t.txTime as txTime
        from TxHistory t
        where t.account.id = :accountId
        order by t.txTime desc
    """)
    List<TxView> findTxByAccountId(@Param("accountId") int accountId);

    // 2️ Transactions by type
    List<TxHistory> findByAccount_IdAndType(
            int accountId,
            BankTxType type
    );

    // 3️ Transaction count
    @Query("""
        select count(t)
        from TxHistory t
        where t.account.id = :accountId
    """)
    long countTxForAccount(@Param("accountId") int accountId);
}
