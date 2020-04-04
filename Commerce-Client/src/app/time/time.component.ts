import { Component, OnInit } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RuleComponent } from '../rule/rule.component';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {

  beginTime: string; 
  endTime: string; 
  constructor(public activeModal: NgbActiveModal, private modalService: NgbModal) { }

  ngOnInit(): void {
  }
  goBack(){
    const modalRef = this.modalService.open(RuleComponent);
  }
  addRule(){
    console.log(this.beginTime); 
    console.log(this.endTime); 
    
  }

}
