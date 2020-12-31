import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator-home',
  templateUrl: './calculator-home.component.html',
  styleUrls: ['./calculator-home.component.css']
})
export class CalculatorHomeComponent implements OnInit {

  result = 0;
  operator = "";
  temp_result = 0;

  compute(x,y,op){
    if(op === "+"){
      return x+y;
    } else if(op === "-"){
      return x-y;
    } else if(op === "x"){
      return x*y;
    } else if(op === "/"){
      if(y==0){
        return NaN;
      } else {
        return x/y;
      }     
    } else {
      return y;
    }
  }

  onResetClick(event?: KeyboardEvent) {
    this.result = 0;
    this.temp_result = 0;
    this.operator = "";
  }

  onEqualsClick(event?: KeyboardEvent) {
    this.result = this.compute(this.temp_result,this.result,this.operator);
  }

  onPlusClick(event?: KeyboardEvent) {
    this.temp_result = this.result;
    this.result = 0;
    this.operator = "+";
  }
  onMinusClick(event?: KeyboardEvent) {
    this.temp_result = this.result;
    this.result = 0;
    this.operator = "-"; 
  }
  onMultiplyClick(event?: KeyboardEvent) {
    this.temp_result = this.result;
    this.result = 0;
    this.operator = "x";
  }
  onDivideClick(event?: KeyboardEvent) {
    this.temp_result = this.result;
    this.result = 0;
    this.operator = "/";  
  }

  on0Click(event?: KeyboardEvent) {
    this.result = this.result*10;   
  }
  on1Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 1;   
  }
  on2Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 2;   
  }
  on3Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 3;   
  }
  on4Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 4;   
  }
  on5Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 5;   
  }
  on6Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 6;   
  }
  on7Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 7;   
  }
  on8Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 8;   
  }
  on9Click(event?: KeyboardEvent) {
    this.result = this.result*10 + 9;   
  }

  constructor() { }

  ngOnInit(): void {
  }

}
