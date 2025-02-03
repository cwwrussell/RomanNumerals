const isSuccess = (status: number) => status >= 200 && status <= 299;

const unwrap = async (response: Response) => {
  if (!isSuccess(response.status) || !response.ok) {
    const error = await response.json();
    throw Error(error?.error ?? "Unknown error");
  }
  return response.json();
};

const HttpUtils = {
  unwrap,
};

export default HttpUtils;
