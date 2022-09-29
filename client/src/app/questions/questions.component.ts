import { Component, OnInit } from '@angular/core';
import { Apollo } from 'apollo-angular';
import { GET_QUESTIONS } from '../graphql.queries';

export interface Question {
    question: string,
    answer: string,
    pictureUrl?: string
}

@Component({
    selector: 'app-questions',
    templateUrl: './questions.component.html',
    styleUrls: ['./questions.component.scss']
})
export class QuestionsComponent implements OnInit {
    questions: Question[] = [];
    error: string = "";
    serverUrl: string = "http://localhost:8080/";

    r: number = 255;
    g: number = 255;
    b: number = 255;

    qOrA: string = 'Q';
    
    constructor(private apollo: Apollo) { }
    
    ngOnInit(): void {
        this.getQuestions();
    }

    getPictureUrl(url: string): string {
        return this.serverUrl + url;
    }

    continue(): void {
        switch(this.qOrA) {
            case 'Q':
                this.qOrA = 'A';
                break;
            case 'A':
                this.getQuestions();
                break;
        }
    }

    getQuestions(): void {
        this.apollo.watchQuery({
            query: GET_QUESTIONS,
            variables: {amount: 1}
        }).valueChanges.subscribe(({data, error}: any) => {
            this.questions = data.questions;
            console.log(this.questions)

            this.r = this.randomIntFromInterval(150, 230);
            this.g = this.randomIntFromInterval(150, 230);
            this.b = this.randomIntFromInterval(150, 230);

            this.error = error;

            this.qOrA = 'Q';
        })
    }

    randomIntFromInterval(min: number, max: number): number { // min and max included 
        return Math.floor(Math.random() * (max - min + 1) + min)
    }
}
