#!/bin/sh

# Start Ollama server in background
ollama serve &

# Wait for Ollama to be ready
echo "Waiting for Ollama server to be active..."
while ! ollama list | grep -q 'NAME'; do
  sleep 1
done

# Pull the model
ollama pull deepseek-r1:7b

# Keep the process running
wait $!