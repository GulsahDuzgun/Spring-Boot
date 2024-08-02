export async function getTasks() {
  const response = await fetch("http://127.0.0.1:4445/task/api/v1/list");

  if (!response.ok)
    throw new Error("There is an error occured while fetching tasks ");

  const data = await response.json();

  console.log(data);
  return data;
}
