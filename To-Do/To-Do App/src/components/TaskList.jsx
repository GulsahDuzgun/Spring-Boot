import { useQuery } from "@tanstack/react-query";
import TaskItem from "./TaskItem";

import { getTasks } from "../utils/helpers";

export default function TaskList() {
  const { data } = useQuery({
    queryFn: getTasks,
    queryKey: ["tasks"],
  });

  return (
    <div className='tasksContainer'>
      <TaskItem tasks={data} />
    </div>
  );
}
