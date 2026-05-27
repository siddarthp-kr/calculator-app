import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { inject } from '@angular/core'; 

@Injectable({
  providedIn: 'root',
})
export class Api {
    private http = inject(HttpClient)
    

    testFunction(){
      this.http.post('http://localhost:8080/api/calculator/calculation', {id: 1, calc: "1+5"}).subscribe()
    }
}
