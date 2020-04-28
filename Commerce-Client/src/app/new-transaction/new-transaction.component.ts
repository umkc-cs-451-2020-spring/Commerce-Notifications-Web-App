import { Component, OnInit, Injectable } from '@angular/core';
<<<<<<< HEAD
import { NgbActiveModal, NgbModal, NgbTimeAdapter, NgbTimeStruct, NgbDateAdapter, NgbDateParserFormatter, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
=======
import { NgbActiveModal, NgbTimeAdapter, NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';
>>>>>>> 51148369e31154803c8265752cd132c0cd80622d
import { Transaction } from '../models/transaction';
import { TransactionService } from '../services/transaction.service';

@Component({
  selector: 'app-new-transaction',
  templateUrl: './new-transaction.component.html',
  styleUrls: ['./new-transaction.component.css']
})
export class NewTransactionComponent implements OnInit {

  newTransaction = new Transaction();
  startMeridian = true;
  endMeridian = true;

  constructor(public activeModal: NgbActiveModal, private transactionService: TransactionService) {
  }

  ngOnInit(): void {
  }

  addNewTransaction() {
    this.transactionService.addNewTransaction(this.newTransaction).subscribe(response => console.log(response));
  }
}

const pad = (i: number): string => i < 10 ? `0${i}` : `${i}`;
@Injectable()
export class NgbTimeStringAdapter extends NgbTimeAdapter<string> {

  fromModel(value: string| null): NgbTimeStruct | null {
    if (!value) {
      return null;
    }
    const split = value.split(':');
    return {
      hour: parseInt(split[0], 10),
      minute: parseInt(split[1], 10),
      second: parseInt(split[2], 10)
    };
  }

  toModel(time: NgbTimeStruct | null): string | null {
    return time != null ? `${pad(time.hour)}:${pad(time.minute)}:${pad(time.second)}` : null;
  }

}

