import { Component, OnInit } from '@angular/core';
import { Apollo } from 'apollo-angular';
import { query } from 'express';
import { GET_QUESTIONS } from '../graphql.queries';

export interface Question {
    question: string,
    answer: string,
    pictureUrl?: string
}

@Component({
    selector: 'app-questions',
    templateUrl: './questions.component.html',
    styleUrls: ['./questions.component.sass']
})
export class QuestionsComponent implements OnInit {

    questions: Question[] = [];
    error: string = "";
    
    constructor(private apollo: Apollo) { }
    
    ngOnInit(): void {
        this.apollo.watchQuery({
            query: GET_QUESTIONS,
            variables: {amount: 2}
        }).valueChanges.subscribe(({data, error}: any) => {
            this.questions = data.questions;
            console.log(this.questions)

            this.error = error;
        })
    }
    
}
