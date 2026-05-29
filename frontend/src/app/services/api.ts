import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { inject } from '@angular/core'; 
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Api {
    private http = inject(HttpClient)
    

    testFunction(){
      this.http.post('http://localhost:8080/api/calculator/calculation', {id: 1, calc: "1+5"}).subscribe()
    }

    async sendCalculationToBackend(calculation: string): Promise<string>{
      //let jsonVal = {calc: calculation}
      // const result = await firstValueFrom(this.http.post('http://localhost:8080/api/calculator/calculation', calculation, {responseType: 'text'}))
      // return result;

        let num1 = parseFloat(calculation.split(/[\+\-\*\/]/)[0]);
        let num2 = parseFloat(calculation.split(/[\+\-\*\/]/)[1]);
        let operation = calculation.match(/[\+\-\*\/]/)?.[0];

        const body = {
          num1: num1,
          num2: num2,
          operation: operation
        };

        const result = await firstValueFrom(
          this.http.post(
            'http://localhost:8080/api/calculator/calculation',
            body,
            { responseType: 'text' }
          )
        );

        return result;

    }
}
