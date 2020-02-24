CREATE TABLE IF NOT EXISTS ping_pong (
    id SERIAL PRIMARY KEY,
    player1 TEXT NOT NULL,
    player2 TEXT NOT NULL,
    player1_score INTEGER NOT NULL DEFAULT 0 CHECK (player1_score >= 0),
    player2_score INTEGER NOT NULL DEFAULT 0 CHECK (player2_score >= 0)
);
