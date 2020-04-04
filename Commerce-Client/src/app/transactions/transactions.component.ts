import { Component, OnInit } from '@angular/core';

import { TransactionService } from '../services/transaction.service';

interface Transaction {
  account: string;
  date: string;
  balance: number;
  amount: number;
  description: string;
}

const TRANSACTIONS: Transaction[] = [
  {account: 'Checking', date: '02/29/20', balance: 245.05, amount: 12.24, description: 'Panda Express'},
  {account: 'Checking', date: '03/01/20', balance: 232.81, amount: 6.45, description: 'Walmart'},
  {account: 'Checking', date: '03/01/20', balance: 226.36, amount: 7.87, description: 'Hy-Vee'},
];

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  transactions = TRANSACTIONS;
  constructor(private transactionService: TransactionService) {
    this.testSpring();
   }

  ngOnInit(): void {
  }

  testSpring() {
    this.transactionService.testSpring().subscribe(transaction => {
      console.log(transaction);
    });
  }
}
