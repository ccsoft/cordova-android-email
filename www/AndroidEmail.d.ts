declare module CC {
    export interface IAndroidEmail {
        getEmail: (successcb: (email: string) => void, failcb: (err: string) => void) => void;        
    }
}
