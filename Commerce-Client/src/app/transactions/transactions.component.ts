import { Component, OnInit } from '@angular/core';
import {NgbDate, NgbCalendar, NgbDateParserFormatter, NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Transaction } from '../models/transaction';
import { NewTransactionComponent } from '../new-transaction/new-transaction.component';
import { TransactionService } from '../services/transaction.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  transactions: Transaction[];
  
 

  constructor(private transactionService: TransactionService,private modalService: NgbModal) {
    this.getTransactions();

   }

  ngOnInit(): void {
  }
  openNewTransaction() {
    const modalRef = this.modalService.open(NewTransactionComponent);
  }

  // TODO Store logged in user's ID for getTransactions parameter
  getTransactions() {
    this.transactionService.getTransactions(2).subscribe(transaction => {
      this.transactions = transaction;
    });
  }

  reload(){
    location.reload(); 
  }
}
