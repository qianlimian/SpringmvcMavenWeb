package com.myspring.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class TransactionExample {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSourcce;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private TransactionTemplate transactionTemplate;

	public DataSource getDataSourcce() {
		return dataSourcce;
	}

	public void setDataSourcce(DataSource dataSourcce) {
		this.dataSourcce = dataSourcce;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@SuppressWarnings("unchecked")
	public void transactionOperation() {
		transactionTemplate.execute(new TransactionCallback() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					Connection conn = dataSourcce.getConnection();
					Statement stmt = conn.createStatement();
					stmt.execute("insert into tb_user(name,age,sex) values('小强','26','男')");
					stmt.execute("insert into tb_user(name,age,sex) values('小红','22','女')");
					System.out.println("操作执行成功！");
				} catch (SQLException e) {
					transactionManager.rollback(status);
					System.out.println("操作执行失败，事务回滚！");
					System.out.println("原因：" + e.getMessage());
				}
				return null;
			}
		});
	}
}
