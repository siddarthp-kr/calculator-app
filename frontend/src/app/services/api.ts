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
      const result = await firstValueFrom(this.http.post('http://localhost:8080/api/calculator/calculation', calculation, {responseType: 'text'}))
      return result;
    }
}
