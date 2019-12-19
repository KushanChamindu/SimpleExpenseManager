package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.DBHelpFile;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.SaveAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.SaveTransactionDAO;

public class PersistentExpenseManager extends ExpenseManager{
    private DBHelpFile db;
    public PersistentExpenseManager(DBHelpFile db) {
        this.db = db;
        setup();
    }

    @Override
    public void setup() {

        TransactionDAO persistentTransactionDAO = new SaveTransactionDAO(db);
        setTransactionsDAO(persistentTransactionDAO);

        AccountDAO persistentAccountDAO = new SaveAccountDAO(db);
        setAccountsDAO(persistentAccountDAO);

    }
}
