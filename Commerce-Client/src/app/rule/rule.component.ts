import { Component, OnInit} from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AmountComponent } from '../amount/amount.component';
import { CategoryComponent } from '../category/category.component';
import { TimeComponent } from '../time/time.component';
import { LocationComponent } from '../location/location.component';


@Component({
  selector: 'app-rule',
  templateUrl: './rule.component.html',
  styleUrls: ['./rule.component.css']
})
export class RuleComponent implements OnInit {

  constructor(public activeModal: NgbActiveModal, private modalService: NgbModal) {}

  ngOnInit(): void {
  }

  openAmount() {
    console.log("Amount");
    const modalRef = this.modalService.open(AmountComponent);
  }

  openLocation(){
    console.log("Location")
    const modalRef = this.modalService.open(LocationComponent);
  }

  openTime(){
    console.log("Time")
    const modalRef = this.modalService.open(TimeComponent);
  }

  openCategory(){
    console.log("Category")
    const modalRef = this.modalService.open(CategoryComponent);
  }

}
