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
    
    constructor(private apollo: Apollo) { }
    
    ngOnInit(): void {
        this.getQuestions();
    }

    getPictureUrl(url: string): string {
        return this.serverUrl + url;
    }

    getQuestions() {
        this.apollo.watchQuery({
            query: GET_QUESTIONS,
            variables: {amount: 1}
        }).valueChanges.subscribe(({data, error}: any) => {
            this.questions = data.questions;
            console.log(this.questions)

            this.error = error;
        })
    }
    
}
