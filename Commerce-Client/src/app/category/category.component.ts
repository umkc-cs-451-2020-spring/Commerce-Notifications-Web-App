import { Component, OnInit } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RuleComponent } from '../rule/rule.component';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  cat: string; 

  constructor(public activeModal: NgbActiveModal, private modalService: NgbModal) { }

  ngOnInit(): void {
  }
  goBack(){
    const modalRef = this.modalService.open(RuleComponent);
  }

  addRule(){
    console.log(this.cat);
  }

}
