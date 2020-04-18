import { Component, OnInit, Injectable} from '@angular/core';
import { NgbActiveModal, NgbModal, NgbTimeAdapter, NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';
import { Rule } from '../models/rule';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-rule',
  templateUrl: './rule.component.html',
  styleUrls: ['./rule.component.css']
})
export class RuleComponent implements OnInit {
  rule = new Rule();
  startMeridian = true;
  endMeridian = true;

  constructor(public activeModal: NgbActiveModal, private notificationService: NotificationService) {
    this.rule.userId = 2;
  }

  ngOnInit(): void {
  }

  addRule() {
    this.notificationService.addRule(this.rule).subscribe(response => console.log(response));
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
