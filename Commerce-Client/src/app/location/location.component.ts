import { Component, OnInit } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RuleComponent } from '../rule/rule.component';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
  loc: string; 
  constructor(public activeModal: NgbActiveModal, private modalService: NgbModal) { }

  ngOnInit(): void {
  }
  goBack(){
    const modalRef = this.modalService.open(RuleComponent);
  }
  addRule(){
    console.log(this.loc);
  }

}
