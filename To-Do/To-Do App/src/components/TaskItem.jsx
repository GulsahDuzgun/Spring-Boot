export default function TaskItem({ tasks }) {
  return tasks?.map((task) => (
    <li className='task' key={task.id}>
      <p className='task--title'>{task.taskName}</p>
      <p className='task--text'>{task.task}</p>
    </li>
  ));
}
