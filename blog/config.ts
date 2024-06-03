function required(key: string, defaultValue = undefined) {
  const value = process.env[key] || defaultValue;
  if (value == null) {
    throw new Error(`Key ${key} is undefined`);
  }

  return value;
}


export const config = {
  email: {
    auth_user    : required('AUTH_USER'),
    auth_password: "kizd wbkn eiej pcgr", //required('AUTH_PASS'),
    service      : 'Gmail',
    host         : 'smtp.gmail.com',
    port         : 465,
    secure       : true,
  },
};