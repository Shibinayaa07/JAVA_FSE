const { TextEncoder, TextDecoder } = require('util');
global.TextEncoder = TextEncoder;
global.TextDecoder = TextDecoder;

try {
  const { ReadableStream } = require('stream/web');
  if (typeof global.ReadableStream === 'undefined') {
    global.ReadableStream = ReadableStream;
  }
} catch (e) {
  console.error("Could not polyfill ReadableStream", e);
}

try {
  const { MessageChannel } = require('worker_threads');
  if (typeof global.MessageChannel === 'undefined') {
    global.MessageChannel = MessageChannel;
  }
  if (typeof global.MessagePort === 'undefined') {
    const channel = new MessageChannel();
    global.MessagePort = channel.port1.constructor;
  }
} catch (e) {
  console.error("Could not polyfill MessageChannel/MessagePort", e);
}
