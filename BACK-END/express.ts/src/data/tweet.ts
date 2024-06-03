type TweetData = {
  id       : string;
  text     : string;
  createdAt: Date  ;
  name     : string;
}

type Tweet = TweetData & {
  username: string;
  url?    : string;
}

const tweets: Tweet[] = [
  {
    id: '1',
    text: '드림코더분들 화이팅!',
    createdAt: new Date,
    name: 'Bob',
    username: 'bob',
    url: 'https://widgetwhats.com/app/uploads/2019/11/free-profile-photo-whatsapp-1.png',
  },
  {
    id: '2',
    text: '안뇽!',
    createdAt: new Date,
    name: 'Ellie',
    username: 'ellie',
  },
];
