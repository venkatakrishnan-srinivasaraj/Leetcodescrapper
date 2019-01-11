select user.username,problem.id,problem.description,difficulty_level.difficulty_level,solved_status.solved_status from user
inner join user_problem on user.id = user_problem.user_id 
inner join problem on user_problem.problem_id = problem.id
inner join difficulty_level on problem.difficulty_level_id = difficulty_level.id
inner join solved_status on user_problem.solved_status_id = solved_status.id;
