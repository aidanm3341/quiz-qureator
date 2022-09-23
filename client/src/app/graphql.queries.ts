import { gql } from "apollo-angular";

const GET_QUESTIONS = gql`
    query GetQuestions($amount: Int) {
        questions(amount: $amount) {
            question,
            answer,
            ... on PictureQuestion {
                pictureUrl
            }
        }
    }
`;

export { GET_QUESTIONS }