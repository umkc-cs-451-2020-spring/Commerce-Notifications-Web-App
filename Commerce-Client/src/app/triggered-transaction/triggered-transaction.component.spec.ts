import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TriggeredTransactionComponent } from './triggered-transaction.component';

describe('TriggeredTransactionComponent', () => {
  let component: TriggeredTransactionComponent;
  let fixture: ComponentFixture<TriggeredTransactionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TriggeredTransactionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TriggeredTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
