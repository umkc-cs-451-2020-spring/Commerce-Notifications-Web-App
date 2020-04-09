import { Component, OnInit } from '@angular/core';

import { Transaction } from '../models/transaction';
import { TransactionService } from '../services/transaction.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  page = 1;
  pageSize = 10;
  collectionSize = 0;
  transactionCollection: Transaction[];

  constructor(private transactionService: TransactionService) {
    this.getTransactions();
   }

  ngOnInit(): void {
  }

  get transactions(): Transaction[] {
    this.pageSize = this.pageSize === -1 ? this.collectionSize : this.pageSize;
    return this.transactionCollection
      .map((transaction, i) => ({id: i + 1, ...transaction}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }

  // TODO Store logged in user's ID for getTransactions parameter
  getTransactions() {
    this.transactionService.getTransactions(2).subscribe(transaction => {
      this.transactionCollection = transaction;
      this.collectionSize = this.transactionCollection.length;
    });
  }
}
